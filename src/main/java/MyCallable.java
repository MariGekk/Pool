import java.util.concurrent.Callable;

// Класс, реализующий интерфейс Callable
class MyCallable implements Callable<String>
{

    public int k = 0;

    @Override
    public String call() throws Exception {
       // Thread.sleep(1000);
        // наименование потока, выполняющего
        // callable задачу
        k= k+1;
        System.out.println(Thread.currentThread().getName());
        return String.valueOf(k);

    }
}

    

