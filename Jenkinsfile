pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build Project') {
            steps {
                echo 'Building Java application...'
                bat 'mvn clean package -DskipTests -Dmaven.test.failure.ignore=true'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn sonar:sonar -Dsonar.login=squ_811a33edc342c9ca335d62e5061a5d1027634833'
                }
            }
        }
    }
}
