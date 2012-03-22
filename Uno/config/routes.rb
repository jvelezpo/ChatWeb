Chatter::Application.routes.draw do
  resources :deportes
  resources :cocinas

  root :to => 'pages#index'
end
