class CreateMensajes < ActiveRecord::Migration
  def change
    create_table :mensajes do |t|
      t.string :de
      t.string :texto

      t.timestamps
    end
  end
end
