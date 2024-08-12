package HW_1.HW_2.factoryMethod.TemplateMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PoemReader extends LogReader{

    private String data;

    @Override
    public Object getDataSourse() {
        return data;
    }

    @Override
    public void setDataSourse(Object data) {
        this.data = data.toString();
    }

    public PoemReader(){

    }

    public PoemReader(String data){
        this.data = data;
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner scanner = new Scanner(data);
        List<String> logList = new ArrayList<String>();
        int counter = 0;
        while(scanner.hasNextLine()){
            counter ++;
            if (counter >= position){
                position =  counter;
                String line = scanner.nextLine();
                logList.add(line);
            }
            else {
                scanner.nextLine();
            }
        }
        return logList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {

        return new LogEntry(stringEntry);
    }
}