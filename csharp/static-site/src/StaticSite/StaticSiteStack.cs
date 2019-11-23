using Amazon.CDK;

namespace StaticSite
{
    public class StaticSiteStack : Stack
    {
        //
        // This stack relies on getting the domain name from CDK context.
        // Use 'cdk synth -c domain=mystaticsite.com -c subdomain=www'
        // Or add the following to cdk.context.json:
        // {
        //   "context": {
        //     "domain": "mystaticsite.com",
        //     "subdomain": "www"
        //   }
        // }
        // 
        public StaticSiteStack(Construct parent, string id, IStackProps props) : base(parent, id, props)
        {
            // You can also define your own constructs and use them in your stack.
            StaticSiteConstruct hello = new StaticSiteConstruct(this, "MyStaticSite", new StaticSiteConstructProps()
            {
                DomainName= (string) this.Node.TryGetContext("domain"),
                SiteSubDomain= (string) this.Node.TryGetContext("subdomain")
            });
        }
    }
}
