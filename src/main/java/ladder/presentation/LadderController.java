package ladder.presentation;

import ladder.application.Items;
import ladder.application.Ladder;
import ladder.application.RandomSelectStrategy;
import ladder.application.Reward;
import ladder.presentation.converter.ItemConverter;
import ladder.presentation.converter.LadderConverter;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Scanner;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-01
 */
public class LadderController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void play() {
        String topItems = InputView.inputTopItems(scanner);
        Items items = new Items(ItemConverter.toItems(topItems));
        String resultItems = InputView.inputResultItems(scanner);
        items.addResultItems(ItemConverter.toItems(resultItems));

        int height = InputView.inputHeight(scanner);
        Ladder ladder = new Ladder(items.size(), height, new RandomSelectStrategy());
        OutputView.outputLadder(LadderConverter.toLadderResponse(ladder), items.getTopItems(), items.getResultItems());
        Reward reward = new Reward(items, ladder);
        String key = InputView.inputReward(scanner);
        while (!"all".equals(key)) {
            OutputView.outputReward(reward.get(key));
            key = InputView.inputReward(scanner);
        }
        OutputView.outputReward(reward.getAll());
    }
}
