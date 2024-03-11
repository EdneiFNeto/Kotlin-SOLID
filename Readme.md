## SOLID PRINCIPLE

Reduz acoplamento entre componentes do sistema, clean conde.

### Single responsibility Principle(SRP)

Uma classe deve ter apenas um motivo para mudar. Isso siginifica
que cada classe dever ter apenas uma responsabilidade.

__OBS__ Quando uma classe tem mais de uma responsabilidade, 
isso pode levar a um acoplamento forte entre funcionalidades
diferentes

Exemplo: Um canivete

#### Boas práticas:
 - Identificar as reponsabilidades
 - Refatorar quando necessário
 - Testa cada responsabilidade selaradamente

### Open close Principle(OSP)

Afirma que as entidades de software devem esta aberta para extenão
mais fechadas para modificação.

__OBS__ De uma feature existente onde a mesma nunca deve ser modificada e sim ser 
extendida.

Exemplo tipo de pagamento.

### Liskov Substitution Principle(LSP)

Objetos de uma classe derivada deve ser capaz de substitui objetos de uma classe base sem que o 
programa seja afetado.

Deve criar subcalsses que herdam da classe pai

### Interface Segregation Principle(ISP)
### Dependency Inversion Principle(DIP)


