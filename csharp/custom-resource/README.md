
# Custom Resource
<!--BEGIN STABILITY BANNER-->
---

![Stability: Stable](https://img.shields.io/badge/stability-Stable-success.svg?style=for-the-badge)

> **This is a stable example. It should successfully build out of the box**
>
> This example depends only on the core CDK library (and Lambda), and does not have any infrastructure prerequisites to build.

---
<!--END STABILITY BANNER-->

This example shows adding a custom resource to a CDK app. This custom resource is useful when considering design of constructs, or separating your architecture into components.

## Build

To build this app, you need to be in this example's root folder. Then run the following:

```bash
npm install -g aws-cdk
dotnet build src
```

This will install the necessary CDK, then this example's dependencies, and then build your TypeScript files and your CloudFormation template.

## Deploy

Run `cdk deploy CustomResourceStack`. This will deploy / redeploy your Stack to your AWS Account.

After the deployment you will see the API's URL, which represents the url you can then use.

## Synthesize Cloudformation Template

To see the Cloudformation template generated by the CDK, run `cdk synth CustomResourceStack`, then check the output file in the "cdk.out" directory.