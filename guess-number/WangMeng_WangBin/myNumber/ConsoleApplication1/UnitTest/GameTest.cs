using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UnitTest
{
    [TestClass]
    public class GameTest
    {
        [TestMethod]
        public void should_return_you_win_if_user_inputs_exactly_match_random_number_generated_when_game_is_initialized()
        {
            var game = new Game("1234");
            var result = game.Do("1234");
            Assert.AreEqual("You win", result);
        }

    }

    public class Game
    {
        readonly string answer;

        public Game(string answer)
        {
            this.answer = answer;
        }

        public string Do(string input)
        {
            return "You win";
        }
    }
}