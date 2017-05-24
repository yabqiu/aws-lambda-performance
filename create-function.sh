#!/usr/bin/env bash

aws lambda create-function \
--profile saml \
--function-name lambda-performance-test \
--runtime java8 \
--role "arn:aws:iam::547044695525:role/lambda_basic_execution" \
--handler lambda.Handler \
--description "Test AWS Lambda performance" \
--zip-file fileb://target/lambda-performance-test-1.0.jar
