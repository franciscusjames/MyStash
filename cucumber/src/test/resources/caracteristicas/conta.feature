# language: pt

  @ContaTeste
  Funcionalidade: Testar as operacoes basicas de conta
    O sistema deve prover o saque e deposito na conta de forma correta.
    Seguindo as seguintes restrições:
    1) Só libera o saque, se o valor do saque for menor ou igual ao valor 
        do saldo disponível na conta
    2) Só libera o deposito, se o valor do deposito for menor ou igual ao 
        valor do limite disponível na conta
    
    Esquema do Cenario: Testar saque e deposito
      Dado a conta criada para o dono "<dono>" de numero <numero> com o limite <limite> e saldo <saldo> 
      Quando o dono realiza o deposito no valor de <deposito> na conta
      E o dono realiza o primeiro saque no valor de <primeiro_saque> na conta
      E o dono realiza o segundo saque no valor de <segundo_saque> na conta
      Entao o dono tem o saldo no valor de <saldo_esperado> na conta
    
Exemplos: 
| dono |numero|limite|saldo|deposito|primeiro_saque|segundo_saque|saldo_esperado|
|Brendo| 111  | 1000 | 0   | 100    | 10           | 10          | 80           |
|Hiago | 222  | 1000 | 0   | 200    | 10           | 10          | 180          |


# #: Utilizado para escrever comentário;

# @:Simbologia para marcar uma tag: perceba que estávamos utilizando a tag no escopo máximo da 
#    especificação, mas poderia ser anotada acima de outras palavras-chaves do Gherkin;

# Funcionalidade: Nesta palavra-chave encontra-se uma descrição de alto nível de um recurso de 
#   software. Foi adicionado abaixo desta palavra-chave uma descrição (opcional, mas recomendável) 
#   que pode abranger várias linhas;

# Esquema do Cenario: Informa ao Cucumber que este cenário irá utilizar um conjunto de dados para 
#   executar exemplos N vezes descrito em seu escopo, que no nosso caso irá executar este cenário 
#   duas vezes, pois contém dois registros abaixo da palavra-chave “Exemplos”;

# Passos: Um passo geralmente começa com “Dado”, “Quando” ou “Entao”.

# - Dado: É utilizado para descrever um contexto inicial do cenário. Quando o Cucumber executa a 
#   palavra-chave “Dado”, espera-se que o cenário esteja em um estado definido, por meio e exemplo 
#   de uma criação ou configuração de objetos;

# - Quando: Utilizado para descrever um evento ou ação. Pode-se descrever, por exemplo, uma pessoa 
#   interagindo com o sistema ou pode ser um evento desencadeado por um sistema;

# - E: É semelhante ao “Dado”, “Quando” e “Entao”, pois ele é empregado quando um deles já foi 
#   declarado dentro de um mesmo cenário;

# - Entao: É utilizado para descrever um resultado esperado.

# Exemplos: É utilizado para estabelecer um conjunto de dados a serem executados nos passos definido 
#   no “Esquema do Cenario”;

# """: Informando que o valor é uma string;

# |:É utilizado em “Tabelas de Dados” para separar um conjunto de valores, como é declarado no arquivo
#   anterior, abaixo da palavra-chave “Exemplos”.
