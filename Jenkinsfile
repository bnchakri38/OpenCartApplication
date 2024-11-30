pipeline 
{
    agent any
    
    stages 
    {
        stage('Build') 
        {
            steps
            {
                 echo("Build the project");
            }
        }
    
    stage('Run UAT') 
        {
            steps
            {
                 echo("BuildRun Unit test-cases");
            }
        }
        
    stage('Deploy to Dev') 
        {
            steps
            {
                 echo("Deploying to Dev Environment");
            }
        }
        
    stage('Deploy to QA') 
        {
            steps
            {
                 echo("Deploying to QA Environment");
            }
        }
        
    stage('Run Regression Automation test-cases') 
        {
            steps
            {
                 echo("Run Regression Automation test-cases");
            }
        }
        
    stage('Deploy to Stage') 
        {
            steps
            {
                 echo("Deploying to Stage Environment");
            }
        }
        
    stage('Run Sanity Automation test-cases') 
        {
            steps
            {
                 echo("Run Sanity Automation test-cases");
            }
        }
        
    stage('Deploy to Prod') 
        {
            steps
            {
                 echo("Deploying to Prod Environment");
            }
        }
        
    }
}
