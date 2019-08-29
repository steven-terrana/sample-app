libraries{
    docker{
        registry = "495692436021.dkr.ecr.us-east-1.amazonaws.com"
        repo_path_prefix = "bioceleb"
        ecr{
            cred = "aws" 
            region = "us-east-1" 
        }
    }
    ecs{
        accountNumber = "495692436021"
        region = "us-east-1"
        task = "sample-app-maven"
        cluster = "BDSO-Management-fargate"
        service = "sample-backend"
        cred = "aws" 
    }
}
