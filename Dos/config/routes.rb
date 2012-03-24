Reto4::Application.routes.draw do


  resources :messages
  resource :session

  root :to => "sessions#new"
end
