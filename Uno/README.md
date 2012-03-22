#Autores

####Juan Sebastian Velez Posada
####James David Benitez
####Juan Esteban Mosquera

##Antes
    `gem install faye`
    `gem install thin`
    `bundle install`
    `bundle exec rake db:migrate`
    

##Mode de Uso
Correr primero `rackup faye.ru -s thin -E production`

abrir otra consola y correr `rails s`

abrir el navegador diriguirse a esta direcion: `http://localhost:30000` 

seleccionar la sala y a chatear
