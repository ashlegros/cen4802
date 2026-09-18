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
    }

    post {
        always{
            junit 'target/surefire-reports/*.xml'
        }
    }
}