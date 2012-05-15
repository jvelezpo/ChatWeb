Chatter::Application.routes.draw do
  resources :deportes
  resources :cocinas
  resources :pages
  #resources :inicios
  resource :inicios do
    # Route GET /user/admin_login
    get 'destroy', :on => :collection
  end


  root :to => 'inicios#index'
end
