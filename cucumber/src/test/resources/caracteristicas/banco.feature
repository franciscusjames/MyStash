# language: pt

@BancoTeste
Funcionalidade: Testar as operacoes basicas de banco
  O sistema deve prover operações básicas de banco de forma correta.
  
  Contexto: Cria todas as contas e associa ao banco
    Dado que as contas sao do "Banco do Brasil"
      | dono                       | numero | saldo |
      | Abias Corpus Da Silva      | 111    | 100   |
      | Antônio Morrendo das Dores | 222    | 200   |
      | Carabino Tiro Certo        | 333    | 200   |
  
  Cenario: Verifica o total de contas criadas
    Dado o calculo do total de contas criadas
    Entao o total de contas e 3
  
  Cenario: Verifica o total de dinheiro no banco
    Dado o calculo do total de dinheiro
    Entao o total de dinheiro no banco e 500
    

# Contexto: É utilizando para definir um contexto inicial para cada cenário declarado no arquivo 
#   .feature;

# Cenario: É utilizado para especificar um exemplo concreto que ilustra uma regra de negócio, 
#   basicamente constituída por uma lista de passos.