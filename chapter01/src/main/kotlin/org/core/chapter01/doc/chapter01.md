

### 모듈의 3가지 목적

1. 제대로 동작해야한다.
2. 변경에 용이해야한다.
3. 이해하기 쉬워야 한다.

### 의존성
한 객체가 협력하기 위해 다른 객체를 알고있는것.  
상대가 바뀌면 영향을 받는다.

=> 최소한의 의존성만 유지하고 불필요한 의존성은 제거

의존성이 높으면 **결합도**가 높다고 한다.  
두 객체 사이의 결합도가 높으면 높을수록 함께 변경될 가능성도 높아지기 때문에 변경하기 어려워진다.


```kotlin
// 개선전 Theater
class Theater(  
    val ticketSeller: TicketSeller  
) {  
    fun enter(audience: Audience) {  
        if(audience.bag.hasInvitation()) {  
            val ticket = ticketSeller.ticketOffice.getTicket()  
            audience.bag.setTicket(ticket)  
        } else {  
            val ticket = ticketSeller.ticketOffice.getTicket()  
            audience.bag.minusAmount(ticket.fee)  
            ticketSeller.ticketOffice.plusAmount(ticket.fee)  
            audience.bag.setTicket(ticket)  
        }  
    }  
}
```

`Theater`는  `Audience`, `Bag`,`Ticket` , `TicketSeller`, `TicketOffice` 를 모두 의존하고 있다.  
`Audience`가 `Bag` 대신 다른 객체로 초대장을 검사하도록 바뀌면, `Audience`만 수정하면 끝나야 하는데 `Theater`까지 함께 수정해야 한다.


### 캡슐화
객체 내부의 세부사항을 감추는것.
목적: 변경하기 쉬운 객체를 만드는것.


```kotlin
// 개선후 Theater
class Theater(  
    val ticketSeller: TicketSeller  
) {  
    fun enter(audience: Audience) {  
        ticketSeller.sellTo(audience)  
    }  
}
```

초대장을 검사하고 티켓을 발행하는 세부 로직을 `TicketSeller`에게 위임했다. `Theater`는 `sellTo`만 알면 되고, 더이상 `Ticket`, `Bag`, `TicketOffice` 등을 몰라도 된다.


### 훌륭한 객체지향 설계

- 캡슐화를 이용해 의존성을 적절히 관리함으로써 객체 사이의 결합도를 낮추는것.
- 적절한 객체에 적절한 책임을 할당.
- 적절한 트레이드오프

