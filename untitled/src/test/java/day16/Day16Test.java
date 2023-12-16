package day16;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day16Test {

    @Test
    public void testThing() {

        List<String> lines = new ArrayList<>();
        lines.add(".|...\\....");
        lines.add("|.-.\\.....");
        lines.add(".....|-...");
        lines.add("........|.");
        lines.add("..........");
        lines.add(".........\\");
        lines.add("..../.\\\\..");
        lines.add(".-.-/..|..");
        lines.add(".|....-|.\\");
        lines.add("..//.|....");

        Table table = new Table(lines);
        table.energise();
        table.printTiles();
        table.printPath();

        Assert.assertEquals("Energised tiles ", 46, table.countEngergisedTiles());


    }



}
