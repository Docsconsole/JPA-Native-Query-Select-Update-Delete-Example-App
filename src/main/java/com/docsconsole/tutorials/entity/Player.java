package com.docsconsole.tutorials.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "PLAYER")
@NamedNativeQueries({

        @NamedNativeQuery(
                name = "selectPlayer",
                query = "SELECT * FROM PLAYER WHERE ID = ?",
                resultClass = Player.class
        ),
        @NamedNativeQuery(
                name = "updatePlayer",
                query = "UPDATE PLAYER P SET FIRST_NAME = ? WHERE ID = ?",
                resultClass = Player.class
        ),
        @NamedNativeQuery(
                name = "deletePlayer",
                query = "DELETE FROM PLAYER WHERE FIRST_NAME = ? AND ID = ?",
                resultClass = Player.class
        )
})
public class Player implements Serializable {

    private static final long serialVersionUID = 88889999998L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "game")
    private String game;
    @Column(name = "age")
    private Long age;
    @Column(name = "salary_income")
    private Long salaryIncome;

}
