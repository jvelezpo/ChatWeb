Chatter::Application.routes.draw do
  resources :deportes
  resources :cocinas
  resources :pages
  resources :inicios


  root :to => 'inicios#new'
end
