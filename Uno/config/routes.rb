Chatter::Application.routes.draw do
  resources :messages
  resources :deportes
  resources :cocinas

  root :to => 'messages#index'
end
