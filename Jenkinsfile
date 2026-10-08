pipeline {
    agent any

    stages{
        stage('Obtain Source Code'){
            steps{
                checkout scm
            }
        }

        stage('Build/Test with Maven'){
            steps{
                sh './mvnw -B clean verify'
            }
        }

        stage('Package'){
            steps{
                sh './mvnw -B package -DskipTests'
            }
        }

        stage('Build Docker Image'){
            steps{
                sh '$DOCKER_BIN/docker build -t personal-task-manager .'
            }
        }
    }

    post {
        always{
            junit 'target/surefire-reports/*.xml'
        }
    }
}