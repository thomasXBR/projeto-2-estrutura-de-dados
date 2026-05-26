//*************************** ATENÇÃO! *****************************
// As assinaturas dos métodos desta classe não devem ser alteradas!
//*************************** ATENÇÃO! *****************************
// arquivo: src/apl2/Operation.java

// TODO: Colocar a identificação dos(as) integrantes aqui.

// Thomas Barbosa Bulhões - 10427456
// Enzo Grutila de Oliveira - 10737003


package apl2;

public class Operation {

    /**
     * <p>Recebe como parâmetro uma lista encadeada do tipo {@code LinkedListOriginal}, sendo que os nós da lista estão
     * populados com o conteúdo da base de dados original (conteúdo do arquivo dados.txt).</p>
     * <p>A operação {@code map()} deve mapear os dados originais para uma lista encadeada do tipo {@code DLinkedList} e
     * retornar a referência da {@code DLinkedList} que possui os dados mapeados para a nova estrutura usada pelo sistema de notas.</p>
     *
     * @param original Base de dados original carregada em uma {@code LinkedListOriginal}.
     * @return Uma nova {@code DLinkedList} que contém o mapeamento da coleção de dados {@code original} para a nova estrutura usada pelo sistema de notas.
     */
    // Converte cada nó da lista original para o novo formato, montando uma DLinkedList com os dados atualizados.
    public static DLinkedList map(final LinkedListOriginal original) {
        DLinkedList newList = new DLinkedList();
        NodeOriginal current = original.getHead();

        while (current != null) {
            // Formata o ID com prefixo "23.S1-" e 3 dígitos (ex: 23.S1-111)
            String newId = String.format("23.S1-%03d", current.getId());
            String name = current.getNome();
            float grade;

            // Se qualquer parte da nota for -1, indica ausência de nota (99.9)
            if (current.getInteiro() == -1 || current.getDecimo() == -1) {
                grade = 99.9f;
            } else {
                // Combina parte inteira e decimal em um único float (ex: 8 e 7 viram 8.7)
                grade = current.getInteiro() + current.getDecimo() / 10f;
            }

            newList.append(newId, name, grade);
            current = current.getNext();
        }

        return newList;
    }

    /**
     * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
     * populados com o resultado da operação {@code map()}.</p>
     * <p>A operação {@code filterRemoveNonGraded()} deve filtrar os nós que não possuem notas válidas (caso de "ausência de nota")
     * e retornar uma nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas válidas.</p>
     *
     * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
     * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas válidas.
     */
    // Percorre a lista e retorna uma nova lista contendo apenas os nós com notas válidas (diferentes de 99.9).
    public static DLinkedList filterRemoveNonGraded(final DLinkedList data)
    {
        DLinkedList newList = new DLinkedList();
        Node current = data.getHead();

        while (current != null)
        {
            if (current.getGrade() != 99.9f)
            {
                newList.append(current.getId(), current.getName(), current.getGrade());
            }
            current = current.getNext();
        }

        return newList;
    }

    /**
     * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
     * populados com o resultado da operação {@code map()}.</p>
     * <p>A operação {@code filterRemoveGraded()} deve filtrar os nós que possuem notas válidas e retornar uma nova lista do
     * tipo {@code DLinkedList} contendo apenas os nós com notas inválidas (caso de "ausência de nota").</p>
     *
     * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
     * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas inválidas.
     */
    // Percorre a lista e retorna uma nova lista contendo apenas os nós com ausência de nota (99.9).
    public static DLinkedList filterRemoveGraded(final DLinkedList data)
    {
        DLinkedList newList = new DLinkedList();
        Node current = data.getHead();

        while (current != null)
        {
            if (current.getGrade() == 99.9f)
            {
                newList.append(current.getId(), current.getName(), current.getGrade());
            }
            current = current.getNext();
        }

        return newList;
    }

    /**
     * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
     * populados com o resultado da operação {@code filterRemoveNonGraded()}, e a média de notas válidas, calculadas com a
     * operação {@code reduce()}.</p>
     * <p>A operação {@code filterRemoveBelowAverage()} deve filtrar os nós que possuem notas abaixo da média e retornar uma
     * nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas acima da média.
     *
     * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
     * @param average Média de notas válidas calculada com a operação {@code reduce()}.
     * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada somente com pessoas com notas maiores do que {@code average}.
     */
    // Percorre a lista de notas válidas e retorna uma nova lista apenas com os nós cuja nota supera a média.
    public static DLinkedList filterRemoveBelowAverage(final DLinkedList data, float average)
    {
        DLinkedList newList = new DLinkedList();
        Node current = data.getHead();

        while (current != null)
        {
            if (current.getGrade() > average)
            {
                newList.append(current.getId(), current.getName(), current.getGrade());
            }
            current = current.getNext();
        }

        return newList;
    }

    /**
     * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
     * populados com o resultado da operação {@code filterRemoveNonGraded()}.</p>
     * <p>A operação {@code reduce()} deve calcular a média das notas contidas na coleção de dados passada como parâmetro e
     * retornar a média calculada.
     *
     * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
     * @return Média das notas ({@code float}) contidas na coleção de dados ({@code data}).
     */
    // Calcula e retorna a média aritmética das notas contidas na lista.
    public static float reduce(final DLinkedList data) {
        float sum = 0;
        Node current = data.getHead();

        while (current != null) {
            sum += current.getGrade();
            current = current.getNext();
        }

        // Divide a soma pelo total de nós para obter a média
        return sum / data.count();
    }

    /**
     * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
     * populados com o resultado da operação {@code map()}.</p>
     * <p>A operação {@code mapToString()} deve mapear todos os nós da coleção de dados passada como parâmetro para uma única
     * {@code String}, sendo que cada dado de uma pessoa é separado por ponto-e-vírgula (;) e cada pessoa é separada por uma
     * quebra de linha.</p>
     *
     * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
     * @return {@code String} com a coleção de dados separada por ponto-e-vírgula (dados de cada pessoa) e quebras de linha (cada pessoa).
     */
    // Percorre a lista e monta uma String no formato CSV (id;nome;nota) separando cada pessoa por quebra de linha.
    public static String mapToString(final DLinkedList data)
    {
        String result = "";
        Node current = data.getHead();

        while (current != null) {
            result += current.getId() + ";" + current.getName() + ";" + current.getGrade() + "\n";
            current = current.getNext();
        }

        return result;
    }

}