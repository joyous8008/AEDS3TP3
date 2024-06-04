# AEDS3TP3
Trabalho feito por Pedro Augusto de Paula, Léa Tronel e Loïcia Ribeiro
Primeiro pegamos o arquivo do TP1 para fazer as funções de compressão nele, mas depois houve uma mudança para um TP2 simplificado. Então fizemos um menu para conectar todas as ações e alguns métodos para facilitar a compressão, descompressão e inserção. Uma dificuldade encontrada foi que ao recuperar uma versão com menos registros ainda era possível achar registros de fora dessa versão que estavam mais na frente da memória comparado a essa. Para isso foi criada a classe Endereco que guarda o real endereço do arquivo e é atualizada através de passagem por referência

## Há uma rotina de compactação usando o algoritmo LZW para fazer backup dos arquivos?
Sim

## Há uma rotina de descompactação usando o algoritmo LZW para recuperação dos arquivos?
Sim

## O usuário pode escolher a versão a recuperar? 
Sim, através de um pequeno menu mostrando todos os registros, mas também é possível escolher a mais recente de uma vez

## Qual foi a taxa de compressão alcançada por esse backup? (Compare o tamanho dos arquivos compactados com os arquivos originais) 
Testando um arquivo com o mesmo registro inserido 1000 vezes, o arquivo compactado ficou 9x menor

## O trabalho está funcionando corretamente?
Sim

## O trabalho está completo?
Sim

## O trabalho é original e não a cópia de um trabalho de um colega?
Sim