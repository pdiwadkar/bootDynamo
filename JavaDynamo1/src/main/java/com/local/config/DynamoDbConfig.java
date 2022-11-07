package com.local.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDbConfig {
	
	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDBConfig());
	}
	
	private AmazonDynamoDB amazonDynamoDBConfig() {
		return AmazonDynamoDBClientBuilder.standard().
				withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(
								"dynamodb.ap-south-1.amazonaws.com", "ap-south-1"))
								.withCredentials(new AWSStaticCredentialsProvider(
										new BasicAWSCredentials("AKIAW3NM6BRR5JTSENP2","5ANh1klxS8knP7KS2kxMdbclIqB91Elzr95khxlS")))
								.build(); 
	}

}
