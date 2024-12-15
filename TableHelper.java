import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableHelper {
    private WebElement table;

    public TableHelper(WebElement table) {
        this.table = table;
    }

    public int getRowCount() {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size();
    }

    public int getColumnCount() {
        List<WebElement> columns = table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("td"));
        return columns.size();
    }

    public String getCellData(int rowIndex, int colIndex) {
        WebElement row = table.findElements(By.tagName("tr")).get(rowIndex);
        WebElement cell = row.findElements(By.tagName("td")).get(colIndex);
        return cell.getText();
    }
}