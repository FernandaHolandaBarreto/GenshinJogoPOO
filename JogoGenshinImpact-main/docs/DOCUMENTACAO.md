# Documentação — Aventura da Viajante

## 1. Nome do jogo
**Aventura da Viajante** — jogo de aventura em console inspirado no universo de Genshin Impact.

## 2. Descrição da proposta
O jogador escolhe Lumine ou Aether e percorre regiões de Teyvat. Durante a jornada, pode explorar o mapa, obter gemas e desejos, participar de eventos, realizar missões, enfrentar monstros, obter recursos, fortalecer personagens e utilizar o sistema de desejos.

## 3. Objetivo
O objetivo principal é explorar todas as 13 regiões disponíveis no mapa. Ao marcar todas como exploradas, o jogador conclui a jornada e vence.

## 4. Regras principais
- O jogador escolhe um dos dois viajantes e informa seu nome.
- Cada região pode ser explorada uma única vez e concede 4.000 gemas e 10 desejos.
- O jogador pode utilizar gemas ou desejos para realizar invocações. Cada desejo custa 160 gemas quando não há desejos guardados.
- Duplicatas de personagens são convertidas em constelações, até o limite C6.
- Enfrentar um monstro custa 1.000 pontos de vida e concede materiais e Mora. Se a vida chegar a zero, ocorre derrota e a partida termina.
- A Estátua dos Sete recupera a vida do jogador.
- Eventos podem ser concluídos uma vez cada e concedem a recompensa indicada.
- A partida também pode ser encerrada voluntariamente pela opção Sair.

## 5. Principais classes e responsabilidades

| Classe | Responsabilidade |
|---|---|
| `Main` | Iniciar o jogo, criar os objetos principais, apresentar o menu e controlar vitória, derrota e encerramento. |
| `Jogador` | Guardar os dados do jogador, recursos, vida e controlar gastos e recuperação. |
| `Inventario` | Armazenar itens por nome e quantidade, permitindo adicionar, consultar e consumir. |
| `Mapa` | Apresentar regiões, registrar exploração e verificar se todas foram exploradas. |
| `Personagem` | Representar personagens, níveis, constelações, arma, artefatos e habilidades. |
| `ColecaoPersonagens` | Manter a coleção e converter personagens repetidos em constelações. |
| `Arma` | Representar os dados de uma arma que pode ser equipada. |
| `Artefatos` | Representar um conjunto de artefatos como equipamento independente. |
| `Elemento` | Representar um elemento do jogo, sem tratá-lo incorretamente como personagem. |
| `Reacao` | Representar uma reação entre elementos. |
| `Equipe` | Agrupar até quatro personagens já existentes. |
| `Habilidades` | Definir o contrato comum para executar uma habilidade. |
| `Ultimate` | Implementar a execução do Supremo. |
| `AprimoramentoElemental` | Implementar a execução da habilidade elemental. |
| `Eventos` | Definir a estrutura abstrata e o comportamento comum de eventos. |
| `EventoTestePersonagem`, `EventoExploracao`, `EventoPrincipal`, `EventoSecundario` | Implementar tipos específicos de evento e suas recompensas. |
| `ConteudoExtra` | Coordenar eventos, personagens, monstros, materiais, domínios e banner de armas. |
| `SistemaDePity` e `Desejo` | Controlar invocações e recompensas dos banners. |
| `GuiaDeAventureiro` e `Missoes` | Organizar o acesso às missões e ao conteúdo de aventura. |
| `ConsoleIO` | Centralizar a leitura e a escrita no console. |

## 6. Conceitos de Orientação a Objetos utilizados

### Classes e objetos
As classes modelam elementos do jogo. Por exemplo, `new Jogador(...)` cria o objeto que representa a pessoa jogando; `new Personagem(...)` cria um personagem específico.

### Atributos e métodos
`Jogador` possui atributos como `nome`, `gemas`, `mora` e `vida`, e métodos como `adicionarGemas`, `gastarMora`, `perderVida` e `recuperarVida`.

### Encapsulamento
Os atributos são privados. O estado é consultado ou alterado por métodos públicos, que podem validar operações. Por exemplo, `gastarMora` impede que o saldo fique negativo e `Inventario` não expõe diretamente seu mapa interno para alteração.

### Construtores
Os construtores inicializam objetos em um estado definido. `Jogador` recebe nome e viajante; `Arma` recebe tipo, raridade, atributo e descrição; `Eventos` recebe nome e recompensa.

### Herança
`EventoTestePersonagem`, `EventoExploracao`, `EventoPrincipal` e `EventoSecundario` herdam de `Eventos`. A relação faz sentido porque todos são tipos especializados de evento e compartilham nome e recompensa.

### Polimorfismo
O método `eventos` de `ConteudoExtra` trabalha com uma lista do tipo abstrato `Eventos`, mas executa o método sobrescrito de cada evento concreto. Também existe polimorfismo na interface `Habilidades`: `Ultimate` e `AprimoramentoElemental` implementam `executar` de formas diferentes, e `Personagem.usarHabilidade` recebe uma referência do tipo da interface.

### Abstração
`Eventos` é abstrata porque representa a ideia geral de um evento, mas não define sozinha como cada evento deve acontecer. Cada classe concreta fornece sua implementação de `executar`.

### Interface
`Habilidades` define o contrato `executar(String acao)`. As classes `Ultimate` e `AprimoramentoElemental` cumprem esse contrato, permitindo que o restante do jogo use qualquer habilidade sem depender da classe concreta.

### Composição
`Jogador` cria e mantém seu próprio `Inventario` como parte de sua estrutura. O inventário pertence ao jogador dentro deste modelo.

### Agregação
`Equipe` mantém uma lista de objetos `Personagem` recebidos de fora. Os personagens podem existir na coleção mesmo que uma equipe seja removida; por isso a relação é de agregação.

## 7. Justificativas de modelagem
- Elementos, reações e artefatos não herdam de `Personagem`, pois não são personagens. São conceitos independentes do domínio.
- Os eventos compartilham dados e comportamento, por isso a classe abstrata `Eventos` evita repetição e permite adicionar novos eventos.
- A interface `Habilidades` permite tratar habilidades diferentes de maneira uniforme.
- O inventário é criado pelo jogador e representa parte de seu estado, enquanto a equipe apenas reúne personagens que existem independentemente dela.
- O mapa é responsável por registrar a exploração, e `Main` consulta seu estado para identificar a vitória.

## 8. Condições de vitória, derrota e encerramento
- **Vitória:** todas as 13 regiões foram exploradas.
- **Derrota:** a vida do jogador chega a zero.
- **Encerramento voluntário:** selecionar `0 - Sair` no menu principal.

## 9. Como executar
É necessário ter o JDK 17 ou superior instalado. Na pasta raiz do projeto, execute:

```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out principal.Main
```

No Windows PowerShell, caso o comando `find` não esteja disponível, compile os arquivos pelo terminal da IDE ou use:

```powershell
$arquivos = Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName }
javac -encoding UTF-8 -d out $arquivos
java -cp out principal.Main
```

## 10. Limitações conhecidas
O jogo é executado pelo console e simula parte dos sistemas do universo de referência. O foco do projeto é demonstrar modelagem e conceitos de Orientação a Objetos, não reproduzir integralmente o jogo comercial.
