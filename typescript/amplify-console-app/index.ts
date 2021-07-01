import cdk = require('@aws-cdk/core');
import { CfnApp, CfnBranch } from '@aws-cdk/aws-amplify';

export class AmplifyConsoleAppCdkStack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    const amplifyApp = new CfnApp(this, 'test-app', {
      name: 'your-amplify-console-app-name',
      repository: 'https://github.com/<the-rest-of-the-repository-url>',
      oauthToken: '<your-gitHub-oauth-token>'
    });

    new CfnBranch(this, 'MasterBranch', {
      appId: amplifyApp.attrAppId,
      branchName: 'master' // you can put any branch here (careful, it will listen to changes on this branch)
    });
  }
}

const app = new cdk.App();
new AmplifyConsoleAppCdkStack(app, 'AmplifyConsoleApp');
app.synth();
