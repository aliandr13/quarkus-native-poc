package com.quarkus.poc;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
@Named("test")
public class TestLambda implements RequestHandler<InputObject, OutputObject> {


    @Inject
    ProcessingService service;

    @Override
    public OutputObject handleRequest(InputObject input, Context context) {
        log.info("Input object: " + input);
        return service.process(input).setRequestId(context.getAwsRequestId());
    }
}
