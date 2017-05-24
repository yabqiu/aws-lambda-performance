#!/usr/bin/env bash

aws lambda update-function-code \
--profile saml \
--function-name klambda-performance-test \
--zip-file fileb://target/lambda-performance-test-1.0.jar
