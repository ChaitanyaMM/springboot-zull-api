package com.eyedentify.kafka.util;

import org.apache.log4j.Logger;

import com.eyedentify.kafka.entity.IoTData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

/**
 * Class to convert IoTData java object to JSON String
 * 
 * @author chaitanya
 *
 */
public class IoTDataEncoder implements Encoder<IoTData> {
	
	private static final Logger logger = Logger.getLogger(IoTDataEncoder.class);	
	private static ObjectMapper objectMapper = new ObjectMapper();		
	public IoTDataEncoder(VerifiableProperties verifiableProperties) {

    }
	public byte[] toBytes(IoTData iotEvent) {
		try {
			String msg = objectMapper.writeValueAsString(iotEvent);
			logger.info(msg);
			return msg.getBytes();
		} catch (JsonProcessingException e) {
			logger.error("Error in Serialization", e);
		}
		return null;
	}
}
