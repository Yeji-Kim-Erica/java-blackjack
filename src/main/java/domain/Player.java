package domain;

import java.util.List;

public class Player extends Participant {
    //TODO: 베팅 금액 정보 필드 추가

    public Player(Deck participantDeck, String name) {
        super(participantDeck, name);
    }

    @Override
    public List<Card> getInitialVisibleCards() {
        return super.getDeck().getCards();
    }

    //TODO: 베팅 메서드 추가

}
