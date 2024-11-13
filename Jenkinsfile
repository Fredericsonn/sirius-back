pipeline {
    agent { dockerContainer { image 'ecotracer/back' } }
    environment {
        REPO_URL = "https://github.com/Fredericsonn/sirius-back.git"
        REMOTE_USER = "eco"
        REMOTE_HOST = "172.31.250.187"
        REMOTE_PATH = "/home/eco/app"
    }
    stages {
        stage('Cloning the repository') {
            steps {
                git branch : "master", url: "${env.REPO_URL}"
            }
        }
        stage("Build") {
            steps {
                script {    
                    sh '''
                        mvn clean package
                    '''
                }
            }
        }
        stage("Archive artifact") {
            steps {
                archiveArtifacts artifacts : "target/*.jar", allowEmptyArchive: false
            }
        }
        stage("Deploy to the back server") {
            steps {
                sshagent(['backend']) { 
                    sh """
                        ssh -o StrictHostKeyChecking=no "${env.REMOTE_USER}"@"${env.REMOTE_HOST}" "lsof -ti:8080 | xargs -r kill -9; rm -rf ${env.REMOTE_PATH}/*"
                        scp -o StrictHostKeyChecking=no target/*.jar "${env.REMOTE_USER}"@"${env.REMOTE_HOST}":"${env.REMOTE_PATH}"
                        ssh -t -o StrictHostKeyChecking=no "${env.REMOTE_USER}"@"${env.REMOTE_HOST}" 'cd ${env.REMOTE_PATH} && screen -dmS spring java -jar eco-0.0.1-SNAPSHOT.jar'
                        """
                }
                
            }
        }

    }
    post {
        success {
            echo 'Deployment completed successfully!'
        }
        failure {
            echo 'Deployment failed. Please check the logs.'
        }
    }
}