# HandlerWithThreadExampleAndroid
example using Handler and Thread class in Android using Kotlin language.


A classe Handler recebe objetos Message dentro do seu método handleMessage. Essa classe identifica o contexto atual quanto nós referimos a qual Thread estamos, de background ou a main thread e podemos tambem passar via construtor o Lopper e assim definir o contexto. Ela contem o metodo sendMessage que é responsável por enviar o objeto Message com informações necessárias.

A classe Thread é responsável por criar um novo processo (Thread) para que possa processar alguma tarefa que possa vir a bloquear a Main Thread (UI). Ex: Requisicões de Rede, E/S, processamento de Bitmap, operações no banco de dados.
