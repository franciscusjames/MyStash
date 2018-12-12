# language: pt

  @ContaTeste
  Funcionalidade: Testar as operacoes basicas de conta
    O sistema deve prover o saque e deposito na conta de forma correta.
    Seguindo as seguintes restri��es:
    1) S� libera o saque, se o valor do saque for menor ou igual ao valor 
        do saldo dispon�vel na conta
    2) S� libera o deposito, se o valor do deposito for menor ou igual ao 
        valor do limite dispon�vel na conta
    
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


# #: Utilizado para escrever coment�rio;

# @:Simbologia para marcar uma tag: perceba que est�vamos utilizando a tag no escopo m�ximo da 
#    especifica��o, mas poderia ser anotada acima de outras palavras-chaves do Gherkin;

# Funcionalidade: Nesta palavra-chave encontra-se uma descri��o de alto n�vel de um recurso de 
#   software. Foi adicionado abaixo desta palavra-chave uma descri��o (opcional, mas recomend�vel) 
#   que pode abranger v�rias linhas;

# Esquema do Cenario: Informa ao Cucumber que este cen�rio ir� utilizar um conjunto de dados para 
#   executar exemplos N vezes descrito em seu escopo, que no nosso caso ir� executar este cen�rio 
#   duas vezes, pois cont�m dois registros abaixo da palavra-chave �Exemplos�;

# Passos: Um passo geralmente come�a com �Dado�, �Quando� ou �Entao�.

# - Dado: � utilizado para descrever um contexto inicial do cen�rio. Quando o Cucumber executa a 
#   palavra-chave �Dado�, espera-se que o cen�rio esteja em um estado definido, por meio e exemplo 
#   de uma cria��o ou configura��o de objetos;

# - Quando: Utilizado para descrever um evento ou a��o. Pode-se descrever, por exemplo, uma pessoa 
#   interagindo com o sistema ou pode ser um evento desencadeado por um sistema;

# - E: � semelhante ao �Dado�, �Quando� e �Entao�, pois ele � empregado quando um deles j� foi 
#   declarado dentro de um mesmo cen�rio;

# - Entao: � utilizado para descrever um resultado esperado.

# Exemplos: � utilizado para estabelecer um conjunto de dados a serem executados nos passos definido 
#   no �Esquema do Cenario�;

# """: Informando que o valor � uma string;

# |:� utilizado em �Tabelas de Dados� para separar um conjunto de valores, como � declarado no arquivo
#   anterior, abaixo da palavra-chave �Exemplos�.
