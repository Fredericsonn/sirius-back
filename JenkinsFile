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
        stage("Deploy to the front server") {
            steps {
                sshagent(['backend']) { 
                    sh """
                        ssh -o StrictHostKeyChecking=no "${env.REMOTE_USER}"@"${env.REMOTE_HOST}" "if lsof -ti:8080 > /dev/null; then kill -9 \$(lsof -ti:8080); fi; rm -rf ${env.REMOTE_PATH}/*"
                        scp -o StrictHostKeyChecking=no target/*.jar "${env.REMOTE_USER}"@"${env.REMOTE_HOST}":"${env.REMOTE_PATH}"
                        ssh -o StrictHostKeyChecking=no "${env.REMOTE_USER}"@"${env.REMOTE_HOST}" 'cd ${env.REMOTE_PATH} && screen -d -m java -jar target/eco-0.0.1-SNAPSHOT.jar'
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