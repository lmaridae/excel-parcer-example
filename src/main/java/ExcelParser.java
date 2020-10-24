import models.Question;
import models.Step;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelParser {
    private final static String file = "data/knowledge_base.xlsx";
    public static void main(String[] args) throws IOException {
        List<Question> questions = new ArrayList<>();
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
        Question question;
        List<String> links;
        List<Step> steps;
        for (Row cells : myExcelSheet) {
            question = new Question();
            links = new ArrayList<>();
            steps = new ArrayList<>();
            for (Cell cell : cells) {
                if (!cell.toString().isEmpty()) {
                    switch (cell.getColumnIndex()) {
                        case 0: break;
                        case 1: question.setQuery(cell.getStringCellValue()); break;
                        case 2: question.setClarification(cell.getStringCellValue()); break;
                        case 3: question.setType(cell.getStringCellValue()); break;
                        case 4: question.setQuestion(cell.getStringCellValue()); break;
                        case 5:
                        case 6:
                        case 7: links.add(cell.getStringCellValue()); break;
                        default: {
                            Step step = new Step();
                            step.setValue(cell.getStringCellValue());
                            steps.add(step);
                        }
                    }
                }
            }
            if (question.getQuestion() != null) {
                question.setSteps(steps);
                question.setLinks(links);
                questions.add(question);
            }
        }
        myExcelBook.close();
        for (Question value : questions) {
            System.out.println(value);
        }
    }
}
