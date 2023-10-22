package textAnalyser;

public class Analyze {
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer: analyzers) {
            Label l = analyzer.processText(text);
            if (l != Label.OK) return l;
        }
        return Label.OK;
    }
}