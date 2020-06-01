
# Projeto de POO

O objetivo deste projeto é centrado no desenvolvimentom utilizando a linguagem Java e Programação Orientada por Objetos (POO), de uma adaptação do jogo de blocos __BlockuDoku__. O ambito desta primeira fase é o de modelar e implementar um conjunto de classes que permitam representar a lógica da aplicação e que permitam a sua utilização em modo consola. 

O jogo __BlockuDoku__ consiste numa mistura de Sudoku com jogo de blocos em que o principal objetivo do
jogo passa por efetuar o preenchimento de linhas, colunas ou quadrados, mantendo o tabuleiro com o
mínimo de blocos possíveis.

## Como Jogar

Ao iniciar o progama o utilizador será questionado sobre o seu username desejado. 

Depois será apresentado com o menu principal onde denovo será questionado sobre o que desejará fazer

```
1 – Iniciate New Game
2 – Load Game
3 – Show Personal Scores
4 – TOP 10 Ranks
0 – Exit
```

Ao iniciar um jogo novo será apresentado com o seguindo menu

```
1 – Iniciar novo jogo – modo básico
2 – Iniciar novo jogo – modo avançado
0 - Voltar
```

Em momentos de jogo deverá utlizar `cancel` ou `save` para cancelar o jogo ou para salvar o seu progresso tornando possivel retornar ao seu jogo atual através da opção ``2 - Load Game``.
## Classes

Nesta secção iremos  explicitar algumas das classes mais importantes para este Projeto

### Block

A classe serve para unificar uma peça e o seu nome como um objeto singular

```
public class Block {
    String blockName;
    Piece piece;
```

### BlockGenerator
Utliza o metodo nextInt() do class Random para randomizar qual bloco será criado 

### Board
Composta por um HashMap, onde a Key é a coordenada do seu Value, um Square.

Implementa a interface Serializable

```
public class Board implements Serializable{
    
    private HashMap<String, Square> board;
```

### BoardCleanUpLogic
Classe que contem metodos estaticos que ajudam com a manutenção da Board, nomeadamente a sua limpeza assim com obteção de secções chave come, Big Squares, Rows , Columns.

### Command
Esta classe recebe Strings e faz todo o parsing necessario para as tornar em objetos da Classe Command

```
public class Command {
    
    private String blockCommand;
    private String coordCommand;

public Command(String blockCommand, String coordCommand) {
        
        this.blockCommand = blockCommand.toUpperCase();
        this.coordCommand = coordCommand.toUpperCase();
    }
```

### ErrorCode 
Enumerado que representa os varios errors esperados durante o programa.

```
public enum ErrorCode {
    
    INVALID_ROUND_BLOCK, INVALID_COMMAND, INVALID_BLOCK_INSERTION;
```

### GameRound
GameRound Representa uma jogada in-game onde o jogador seleciona os blocos e onde os que inserir.

Contem a Board, o GameMode do jogo, um ArrayList com os blocos selecionaveis e um contador para o score do jogador.

GameRound implementa Serializable para tornar a classe serializavel

```
public class GameRound implements Serializable {

    private Board board;
    private GameMode gameMode;
    private ArrayList<Block> roundBlocks;
    private int score;
    private String errorMessage;
```

### Parser

A classe Parser importa o Scanner, assim tornando-se a classe que irá ler os inputs do utilizador
tem um metodo que lê a proxima linha e outro que formata uma String para Command

```
public static String readInput() {...}

public static Command getGameCommand(String input) {...}
```
### Piece

Piece é uma classe estática, contem um HashMap semelhante a Board onde é "construida" a peça, um atributo para o seu nome, um atributo para o seu pivot assim como dois outros para as duas dimensões.

```
public abstract class Piece {

    private HashMap<String, Square> piece;
    private PieceName pieceName;
    private String pivot;
    private int rows;
    private int columns;
```
### Score 

Classe score serve como um ajundante para nos ajudar a organizar as nossas listas

Score implementa Serializable para poder ser serializado e Comparable para ser possivel comparar objetos da mesma classe.

### ScoreBoard
Esta classe contem o ArrayList<Score<E>> e os seus variados metodos de manutenção do próprio.

ScoreBoard implementa Serializable para poder ser serializada.

```
public class Scoreboard<E> implements Serializable {

    ArrayList<Score<E>> scoreboard;
    private E element;
```

### Square

Square representa um quadrado, varios quadrados serão utilizados para preencher a Board

Contem apenas um atributo para tornar o square visível `#` ou invisível `.`

Square implementa Serializable para poder ser serializado.

### User

Esta classe representa o User, o seu nome, o jogo que está a jogar e o seu Scoreboard the Scores pessoais

User implementa Serializable para poder ser serializado.

```
public class User implements Serializable {

    private String name;
    private Game game;
    private Scoreboard<Game> personalScores;
```

### UsersFileHandler

Esta classe contem metodos para serializar e desserializar Users 

```
public class UsersFileHandler {

public static void saveFile(Users listOfUsers, String filename) {...}
public static Users readFile(String filename) {...}

}

```