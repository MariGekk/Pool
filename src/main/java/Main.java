

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;


import static java.lang.System.currentTimeMillis;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Определяем пул из 4 потоков

        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Список ассоциированных с Callable задач Future
        List<Future<String>> futures;

        futures = new ArrayList<Future<String>>();

        // Создание экземпляра Callable класса
        Callable<String> callable = new MyCallable();

        for (int i = 0; i < 4; i++){
            /*
             * Стартуем возвращаюший результат исполнения
             * в виде объекта Future поток
             */
            Future<String> future;
            future = executor.submit(callable);
            /*
             * Добавляем объект Future в список для
             * отображения результат выполнения (получение
             * наименования потока)
             */
            futures.add(future);
        }

        for (Future<String> future : futures){
            try {
                // Выводим в консоль полученное значение
                String text = future.get();
                System.out.println(text);
            } catch (InterruptedException |
                    ExecutionException e) {}
        }
        // Останавливаем пул потоков
        executor.shutdown();


    }
}