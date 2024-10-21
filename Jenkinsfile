pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'dockerhub-johannes-cred'
        DOCKERHUB_REPO = 'johannesliikanen/localizedgreeting'
        DOCKER_IMAGE_TAG = 'lg-ver1'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/emotytto00/sportstracker.git'
            }
        }
        stage('Run Tests') {
                    steps {
                        bat 'mvn clean test'
                    }
                }
        stage('Code Coverage') {
                            steps {
                                bat 'mvn jacoco:report'
                            }
                        }
                        stage('Publish Test Results') {
                            steps {
                                junit '**/target/surefire-reports/*.xml'
                            }
                        }
                        stage('Publish Coverage Report') {
                            steps {
                                jacoco()
                            }
                        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}