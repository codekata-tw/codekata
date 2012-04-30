using ConsoleApplication1;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UnitTest
{
    [TestClass]
    public class GuessNumberTest
    {
       

        [TestMethod]
        public void should_return_4A0B_when_all_number_exactly_match_answer()
        {
            var guessNumber = new GuessNumber("5678");
            var result = guessNumber.Validate("5678");
            Assert.AreEqual("4A0B", result);
        }

        [TestMethod]
        public void should_return_3A0B_when_three_numbers_exactly_match_in_answer()
        {
            var guessNumber = new GuessNumber("5678");
            var result = guessNumber.Validate("5679");
            Assert.AreEqual("3A0B", result);
        }

        [TestMethod]
        public void should_return_3A1B_when_three_number_exactly_match__answer_and_one_exit()
        {
            var guessNumber = new GuessNumber("5678");
            var result = guessNumber.Validate("5675");
            Assert.AreEqual("3A1B", result);
        }

        [TestMethod]
        public void should_return_0A0B_when_no_number_exactly_match_answer_and_on_number_exits_in()
        {
            var guessNumber = new GuessNumber("5678");
            var result = guessNumber.Validate("1234");
            Assert.AreEqual("0A0B", result);
        }

        [TestMethod]
        public void should_return_0A4B_when_no_number_exactly_match_answer_and_on_number_exits_in()
        {
            var guessNumber = new GuessNumber("5678");
            var result = guessNumber.Validate("8765");
            Assert.AreEqual("0A4B", result);
        }

    }

    public class GuessNumber
    {
        readonly string answer;

        public GuessNumber(string answer)
        {
            this.answer = answer;
        }

        public string Validate(string input)
        {
            var numberOfA = 0;
            var numberOfB = 0;
            char[] charArray = input.ToCharArray();
            for (var position = 0; position < charArray.Length; position++)
            {
                var charInInput = charArray[position];
                if (ExistAndPositionCorrect(position, charInInput, answer))
                {
                    numberOfA++;
                }

                if (ExistButPositionNotCorrect(position, charInInput, answer))
                {
                    numberOfB++;
                }
            }
            return numberOfA + "A" + numberOfB + "B";
        }

        static bool ExistButPositionNotCorrect(int positionInInput, char charInInput, string answer)
        {
            var positionInAnswer = answer.IndexOf(charInInput);
            return positionInAnswer != -1 && positionInAnswer != positionInInput;
        }

        static bool ExistAndPositionCorrect(int position, char inChar, string answer)
        {
            var positionInAnswer = answer.IndexOf(inChar);
            return positionInAnswer == position;
        }
    }
}