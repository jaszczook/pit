package com.jaszczook.sri3.car;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Component
public class PitReceiver implements SessionAwareMessageListener<Message> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PitReceiver.class);

	private static final String PIT_QUEUE = "pit.q";
	public static final String PIT_REQUEST_QUEUE = "pit-request.q";

	@JmsListener(destination = PIT_QUEUE)
	public void receive(CarData carData) {
		LOGGER.info("PREPARE FOR THE CAR!");
		LOGGER.info("received car data from car monitor = {}", carData);
	}

	@JmsListener(destination = PIT_REQUEST_QUEUE)
	public void onMessage(Message message, Session session) throws JMSException {
		LOGGER.info("PIT REQUEST RECEIVED");
		LOGGER.info("please wait for the decision...");

		String response = "";

		try {
			Thread.sleep(5 * 1000);
			response = considerPitRequest();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		LOGGER.info("the decision is: {}", response);
		LOGGER.info("sending the decision...");

		ObjectMessage responseMessage = new ActiveMQObjectMessage();
		responseMessage.setObject(response);

		MessageProducer producer = session.createProducer(message.getJMSReplyTo());
		producer.send(responseMessage);
	}

	private String considerPitRequest() {
		if (Math.random() < 0.5) {
			return "ACCEPTED";
		}

		return "REJECTED";
	}
}
