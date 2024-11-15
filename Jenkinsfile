pipeline {
    agent none  
    environment {
        REPO_URL = "https://github.com/Fredericsonn/sirius-back.git"
        REMOTE_USER = "eco"
    }
    stages {
        stage('Cloning the repository') {
            agent { 
                docker { 
                    image 'ecotracer/back-agent' 
                } 
            }
            steps {
                git branch: "master", url: "${env.REPO_URL}"
            }
        }
        stage("Build") {
            agent { 
                docker { 
                    image 'ecotracer/back-agent' 
                } 
            }
            steps {
                script {    
                    sh 'mvn clean package'
                }
            }
        }
        stage("Archive artifact") {
            agent { 
                docker { 
                    image 'ecotracer/back-agent' 
                } 
            }   
            steps {
                archiveArtifacts artifacts: "target/*.jar,Dockerfile", allowEmptyArchive: false
            }
        }
        stage("Building Docker Image") {
            agent { 
                docker { 
                    image 'ecotracer/dind' 
                    args '--user root --restart always -v /var/run/docker.sock:/var/run/docker.sock --entrypoint=""'
                } 
            }
            steps {
                script {
                    sh 'docker build -t ${IMAGE_NAME} .'
                }
            }
        }

        stage("Pushing Image to DockerHub") {
            agent { 
                docker { 
                    image 'ecotracer/dind' 
                    args '--user root --restart always -v /var/run/docker.sock:/var/run/docker.sock --entrypoint=""' 
                } 
            }
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh '''
                        docker login -u $USERNAME -p $PASSWORD
                        docker push ${IMAGE_NAME}
                    '''
                }
            }
        }
        stage("Deploy to the back server") {
            agent { 
                docker { 
                    image 'ecotracer/dind' 
                    args '--user root --restart always -v /var/run/docker.sock:/var/run/docker.sock --entrypoint=""'
                } 
            }
            steps {
                sshagent(['backend']) { 
                    sh """
                        ssh -o StrictHostKeyChecking=no "${env.REMOTE_USER}"@"${env.REMOTE_HOST}" "lsof -ti:8080 | xargs -r kill -9; docker rm -f backend"
                        ssh -o StrictHostKeyChecking=no "${env.REMOTE_USER}"@"${env.REMOTE_HOST}" "docker rmi -f ${IMAGE_NAME} && docker run -d --name backend -p 8080:8080 -e DB=${DATABASE_URL} ${IMAGE_NAME}"
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
