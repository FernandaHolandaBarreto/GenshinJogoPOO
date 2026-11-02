# Diagrama de classes — Aventura da Viajante

O diagrama abaixo destaca as classes e relações principais do projeto. As setas de herança apontam para a classe geral; a linha tracejada representa implementação de interface.

```mermaid
classDiagram
    class Main
    class Jogador {
      -String nome
      -String viajante
      -int gemas
      -int desejos
      -int mora
      -int vida
      +adicionarGemas(int)
      +perderVida(int)
      +recuperarVida()
      +consumirDesejo() boolean
    }
    class Inventario {
      -Map itens
      +adicionar(String,int)
      +consumir(String,int) boolean
      +mostrar()
    }
    class Mapa {
      -String[] regioes
      -boolean[] exploradas
      +abrir(Jogador)
      +jornadaConcluida() boolean
    }
    class Personagem {
      -String nomeDoPersonagem
      -int nivel
      -int constelacoes
      +subirNivel(int)
      +equiparArma(Arma)
      +usarHabilidade(Habilidades,String)
    }
    class ColecaoPersonagens {
      -List~Personagem~ personagens
      +adicionarPersonagem(Personagem)
    }
    class Arma
    class Artefatos
    class Elemento
    class Reacao
    class Equipe {
      -List~Personagem~ membros
      +adicionarMembro(Personagem) boolean
      +removerMembro(Personagem) boolean
    }
    class Habilidades {
      <<interface>>
      +executar(String)
    }
    class Ultimate
    class AprimoramentoElemental
    class Eventos {
      <<abstract>>
      -String nomeDoEvento
      -int recompensaEmGemas
      +executar(Jogador)*
    }
    class EventoTestePersonagem
    class EventoExploracao
    class EventoPrincipal
    class EventoSecundario
    class ConteudoExtra
    class SistemaDePity
    class Desejo
    class GuiaDeAventureiro
    class Missoes
    class ConsoleIO

    Main --> Jogador : cria e coordena
    Main --> Mapa
    Main --> ConteudoExtra
    Jogador *-- Inventario : composição
    Mapa --> Jogador : atualiza recompensas
    ColecaoPersonagens o-- Personagem : coleção
    Equipe o-- Personagem : agregação
    Personagem o-- Arma : equipamento
    Personagem ..> Habilidades : utiliza
    Ultimate ..|> Habilidades
    AprimoramentoElemental ..|> Habilidades
    Eventos <|-- EventoTestePersonagem
    Eventos <|-- EventoExploracao
    Eventos <|-- EventoPrincipal
    Eventos <|-- EventoSecundario
    ConteudoExtra --> Eventos : executa polimorficamente
    ConteudoExtra --> Jogador
    ConteudoExtra --> Personagem
    SistemaDePity --> ColecaoPersonagens
    SistemaDePity --> Desejo
    GuiaDeAventureiro --> Missoes
    GuiaDeAventureiro --> ConteudoExtra
```
