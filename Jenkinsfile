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
                    bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar'
                }
            }
        }
    }
}
