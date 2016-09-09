# Spring Boot Microservices with Pact-JVM

This project contains a *very simple* demo of using [consumer-driven contracts](http://martinfowler.com/articles/consumerDrivenContracts.html) to verify the interactions between microservices.
It leverages [Spring Boot](http://projects.spring.io/spring-boot) for both the provider and consumer services.

Testing is achieved using the [pact-jvm](https://github.com/DiUS/pact-jvm project), which is a JVM port of the original [Pact](https://github.com/realestate-com-au/pact).

## Running the Demo

### Step 1 - Execute pact test on consumer side

```console
    $ cd service-consumer && ./gradlew test
```

This will result in the creation of a [Pact JSON](https://github.com/realestate-com-au/pact/wiki/Terminology#pact-file) called `Product_Consumer-Product_Provider.json` at `service-consumer/target/pacts/`.  Here's a current example:

```console
{
    "provider": {
        "name": "Product_Provider"
    },
    "consumer": {
        "name": "Product_Consumer"
    },
    "interactions": [
        {
            "description": "a request for Products",
            "request": {
                "method": "GET",
                "path": "/products/1"
            },
            "response": {
                "status": 200,
                "headers": {
                    "Content-Type": "application/json;charset=UTF-8"
                },
                "body": {
                    "description": "This is the description for product 1",
                    "id": 1
                }
            }
        }
    ],
    "metadata": {
        "pact-specification": {
            "version": "2.0.0"
        },
        "pact-jvm": {
            "version": "3.3.0"
        }
    }
}
```


By virtue of the fact that these tests pass, we know that the `service-consumer` app interacts appropriately with the contract as defined in [ProductRepositoryTest.java](./service-consumer/src/test/java/com/example/microservices/consumer/repository/ProductRepositoryTest.java)

### Step 2 - we want to verify that the `service-provider` app actually provides the expected contract.

```console
    $ cd service-provider && ./gradlew pactVerify
```

You should see output something like these:

```console
Verifying a pact between service-consumer and Product_Provider
  [Using file /Users/projects/pact/microservices-pact-example/service-consumer/target/pacts/Product_Consumer-Product_Provider.json]
  a request for Products
    returns a response which
      has status code 200 (OK)
      includes headers
        "Content-Type" with value "application/json;charset=UTF-8" (OK)
      has a matching body (OK)
:stopProvider
:pactVerify

BUILD SUCCESSFUL
```
