package lotto.controller;

import static lotto.constants.Common.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.GameService;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final GameService gameService;

    public LottoGameController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.gameService = new GameService();
    }

    public void process() {
        this.gameService.setPurchaseAmount(inputPurchasePrice());
        this.gameService.purchaseTickets();
        this.resultView.printPurchasedTickets(this.gameService.getPurchasedTickets());
        this.gameService.setWinningTicket(inputWinningNumbers());
        this.gameService.setBonusNumber(inputBonusNumber());
        this.gameService.processGame();
        this.resultView.printResult(GameResult.values(), this.gameService.getRevenue());
    }
}
