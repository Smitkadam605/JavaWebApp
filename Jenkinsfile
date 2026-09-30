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
                echo 'Building project...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.login=squ_811a33edc342c9ca335d62e5061a5d1027634833 -Dsonar.token=squ_811a33edc342c9ca335d62e5061a5d1027634833'
                }
            }
        }
    }
}
