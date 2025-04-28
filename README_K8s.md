# Démarrer Minikube
minikube start

minikube -p minikube docker-env | Invoke-Expression

minikube -p minikube docker-env

# Lancer registry docker 
docker run -d -p 5000:5000 --restart=always --name registry registry:2

docker-compose build
docker-compose push

# Vérifier la présence des images dans la registry : 
curl http://localhost:5000/v2/_catalog

# Commande pour déployer les composants sur Kubernetes
kubectl apply -f kube/

# Vérifier que tout les pods tournent 
kubectl get pods

# Exposer le front pour pouvoir s'y connecter
minikube service kafka-app-front